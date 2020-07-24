package com.example.camerabugandroid11

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    findViewById<Button>(R.id.camera).setOnClickListener { pickFile() }
  }

  private fun pickFile() {
    val fileUri = getFileUri() ?: return

    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(
      MediaStore.EXTRA_OUTPUT,
      fileUri
    ).addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

    startActivityForResult(intent, REQUEST_CODE)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    val message = "requestCode: ${requestCode}, resultCode: $resultCode, data: $data"
    Log.d(javaClass.simpleName, message)
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
  }

  private fun getFileUri(): Uri? {
    val picturesDirectory: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES) ?: return null
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val file = File(picturesDirectory, "IMG_$timeStamp.jpg")

    return FileProvider.getUriForFile(
      this,
      applicationContext.packageName.toString() + ".provider",
      file
    )
  }

  private companion object {
    const val REQUEST_CODE = 0
  }
}
