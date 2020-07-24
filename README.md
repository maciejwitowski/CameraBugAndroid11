Steps:
1. Click on "Launch camera" button
2. Taking a picture and confirm
Result: NPE in Camera app.

Stacktrace:
```
FATAL EXCEPTION: main
Process: com.android.camera2, PID: 7229
java.lang.NullPointerException
	at com.google.common.base.Preconditions.checkNotNull(Preconditions.java:890)
	at com.google.common.base.Optional.of(Optional.java:103)
	at com.android.camera.captureintent.state.StateSavingPicture.onEnter(StateSavingPicture.java:77)
	at com.android.camera.captureintent.stateful.StateMachineImpl.jumpToState(StateMachineImpl.java:62)
	at com.android.camera.captureintent.stateful.StateMachineImpl.processEvent(StateMachineImpl.java:110)
	at com.android.camera.captureintent.state.StateOpeningCamera$9.onClick(StateOpeningCamera.java:307)
	at android.view.View.performClick(View.java:7448)
	at android.view.View.performClickInternal(View.java:7425)
	at android.view.View.access$3600(View.java:810)
	at android.view.View$PerformClick.run(View.java:28296)
	at android.os.Handler.handleCallback(Handler.java:938)
	at android.os.Handler.dispatchMessage(Handler.java:99)
	at android.os.Looper.loop(Looper.java:223)
	at android.app.ActivityThread.main(ActivityThread.java:7656)
	at java.lang.reflect.Method.invoke(Native Method)
	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)
```  
