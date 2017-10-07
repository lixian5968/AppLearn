package com.lixian.tools.AccessibilityServer;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import java.io.File;

public class ToolsService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d("InstallService", event.toString());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String command = intent.getStringExtra("InstallUrl");
        if (command != null) {
            Uri uri = Uri.fromFile(new File(command));
            Intent localIntent = new Intent(Intent.ACTION_VIEW);
            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            localIntent.setDataAndType(uri, "application/vnd.android.package-archive");
            startActivity(localIntent);
        }
        return super.onStartCommand(intent, flags, startId);
    }




    @Override
    public void onInterrupt() {
    }

    @Override
    protected void onServiceConnected() {
    }
}

