package com.sallout.dtmf_generator;
import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.Log;
import java.util.regex.Pattern;
public class GenerateDTMF extends Thread {


    private Context activity;
    private String number;
    private int audio_level;
    private int durationMs;
    private int sleepTimeMs;
    private int commaWaiteTime ;
    private ToneGenerator mToneGenerator;
    private AudioManager audioManager;


    public GenerateDTMF(Context activity, String number, int audio_level, int durationMs , int sleepTimeMs , int commaWaiteTime) {
        super();
        this.number = number;
        this.activity = activity;
        this.audio_level = audio_level;
        this.durationMs = durationMs;
        this.sleepTimeMs = sleepTimeMs;
        this.commaWaiteTime = commaWaiteTime;
    }


    @Override
    public void run() {
        super.run();

        mToneGenerator = new ToneGenerator(AudioManager.STREAM_MUSIC, audio_level);
        audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audio_level, 0);

        if (isValidInput(number)) {
            String Text = number;
            final String[] myNumber = new String[Text.length()];
            for (int i = 0; i < Text.length(); ++i) {
                myNumber[i] = Text.substring(i, i + 1);
            }
            try {
                for (int i = 0; i < myNumber.length; ++i) {
                    if (myNumber[i].equals(",")) {
                        Thread.sleep(commaWaiteTime);
                    } else {
                        CheckNumberAndRunTons(myNumber[i] + "");
                        Thread.sleep(sleepTimeMs);

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        } else {
            Log.e("DTMF_generator", "error : input should be 123456789 ABCD *# only");

        }
    }

    public void CheckNumberAndRunTons(String numer) {
        switch (numer) {
            case "0":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_0, durationMs);
                break;
            case "1":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_1, durationMs);
                break;
            case "2":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_2, durationMs);
                break;
            case "3":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_3, durationMs);
                break;
            case "4":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_4, durationMs);
                break;
            case "5":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_5, durationMs);
                break;
            case "6":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_6, durationMs);
                break;
            case "7":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_7, durationMs);
                break;
            case "8":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_8, durationMs);
                break;
            case "9":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_9, durationMs);
                break;
            case "A":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_A, durationMs);
                break;
            case "B":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_B, durationMs);
                break;
            case "C":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_C, durationMs);
                break;
            case "D":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_D, durationMs);
                break;
            case "#":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_P, durationMs);
                break;
            case "*":
                mToneGenerator.startTone(ToneGenerator.TONE_DTMF_S, durationMs);
                break;

        }

    }

    public boolean isValidInput(String number) {
        boolean check = false;
        if (Pattern.matches("^[0-9,A,B,C,D,*,#,\\,]*$", number)) {
            check = true;
        }
        return check;
    }


}








