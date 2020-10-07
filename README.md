#DTMF Generator
This library provides methods for playing DTMF (ITU-T Recommendation Q.23), moderation tones (3GPP TS 22.001, CEPT), and proprietary (3GPP TS 31.111) tones. Depending on-call status and routing options, ringtones are mixed with downlink audio or output to speakerphone or headphones. This API is not for generating tones via the uplink audio path.

#Prerequisites
<line>
	
Step 1. Add the JitPack repository to your build file

      allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.MohammedSallout:dtmf_generator:1.0.0'
	}
	
Step 3. Usage

You can user only number 0,1 , 2 , 3 , 4 , 5 , 6,7 ,8 or 9
or A,B,C,D or * or # only
Also, you can use the comma(,) to set sleep time between your input elements, you can specify the sleep time using "commaWaiteTime"

 
     GenerateDTMF generateDTMF = new GenerateDTMF(yourContext ,string , audio_level , durationMs , sleepTimeMs ,commaWaiteTime);
     generateDTMF.start();

	
	
