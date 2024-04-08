package voice.assistant;

import Clock.MyFrame;
import java.io.IOException;
import tictacktoe.MainFrame;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;

import TrainTicketBooking.*;

import SnakeGame.GameFrame;
import Clock.MyFrame;
import marytts.signalproc.effects.*;
import java.io.*;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.JFrame;

public class Main {
	
	// Necessary
	private LiveSpeechRecognizer recognizer;
	
	// Logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	/**
	 * This String contains the Result that is coming back from SpeechRecognizer
	 */
	private String speechRecognitionResult;
	
	//-----------------Lock Variables-----------------------------
	
	/**
	 * This variable is used to ignore the results of speech recognition cause actually it can't be stopped...
	 * 
	 * <br>
	 * Check this link for more information: <a href=
	 * "https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/">https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/</a>
	 */
	private boolean ignoreSpeechRecognitionResults = false;
	
	/**
	 * Checks if the speech recognise is already running
	 */
	private boolean speechRecognizerThreadRunning = false;
	
	/**
	 * Checks if the resources Thread is already running
	 */
	private boolean resourcesThreadRunning;
	
	//---
	
	/**
	 * This executor service is used in order the playerState events to be executed in an order
	 */
	private ExecutorService eventsExecutorService = Executors.newFixedThreadPool(2);
	
	//------------------------------------------------------------------------------------
	
	/**
	 * Constructor
	 */
	public Main() {
		
		// Loading Message
		logger.log(Level.INFO, "Loading Speech Recognizer...\n");
		
		// Configuration
		//Configuration configuration = new Configuration();
		
		// Load model from the jar
		//configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		//configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		
		//====================================================================================
		//=====================READ THIS!!!===============================================
		//Uncomment this line of code if you want the recognizer to recognize every word of the language 
		//you are using , here it is English for example	
		//====================================================================================
		//configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		
		//====================================================================================
		//=====================READ THIS!!!===============================================
		//If you don't want to use a grammar file comment below 3 lines and uncomment the above line for language model	
		//====================================================================================
		
		// Grammar
		//configuration.setGrammarPath("resource:/grammars");
		//configuration.setGrammarName("grammar");
		//configuration.setUseGrammar(true);
                
                
                
                		Configuration config = new Configuration();
		MainFrame mf;
                mf = new MainFrame();
                
                GameFrame sg;//=new GameFrame();
                MyFrame ck;// = new MyFrame();
                Signup ttb = new Signup();
                JFrame jf = new JFrame();
                
                TextToSpeech tts = new TextToSpeech();
                tts.setVoice("cmu-rms-hsmm");
                 tts.speak("Hello i am Seven your voice assistant,How may i help you", 1.0f, false, false);
                 
                 
                 
                  WebDriver driver = null;
                  int windowNumber = -1;
                  int tabNumber = windowNumber;
                  String currentHandle = null;
                 
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("resource:/grammars/9242.dc");
		config.setLanguageModelPath("resource:/grammars/9242.lm");
		
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			
			SpeechResult speechResult = null;
			
			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);
				
                                
				if (voiceCommand.equalsIgnoreCase("Seven Open Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com ");
				} else if (voiceCommand.equalsIgnoreCase("Close")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}
                                //selenium webdriver commands
                                
//                                if(voiceCommand.equalsIgnoreCase("Seven open google")){
//                                try{
//                                 driver.get("https://www.google.com/");
//                                }
//                                catch(Exception e){
//                                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\Voice Assistant\\chromedriver.exe");
//                                    driver = new ChromeDriver();    
//                                    driver.get("https://www.google.com/");
//
//
//                                }}
//                                
//                                else if(voiceCommand.equalsIgnoreCase("Seven open youtube") || voiceCommand.equalsIgnoreCase("Seven change to youtube")){   
//                                    try{
//                                     driver.get("https://www.youtube.com/");    
//                                    }
//                                    catch(Exception e){
//                                        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\VoiceBot-master\\chromedriver.exe");
//                                        driver = new ChromeDriver();    
//                                        driver.get("https://www.youtube.com/");    
//
//
//                                    }
//                                }
                                
                                
                                if (voiceCommand.equalsIgnoreCase("Open youtube")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.youtube.com ");
                                }
                                
                                
                                if (voiceCommand.equalsIgnoreCase("Open Facebook")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.facebook.com ");
                                }
                                
                                
                                if (voiceCommand.equalsIgnoreCase("Open instagram")) {
					Runtime.getRuntime().exec("cmd.exe /c cd C:\\Users\\hp\\OneDrive\\Desktop & start Python.txt");
                                }
                                
                                
				if (voiceCommand.equalsIgnoreCase("Open Chrome in incognito")) {
					Runtime.getRuntime().exec("cmd.exe /c cd C:\\Users\\hp\\OneDrive\\Desktop & start voice_typing.txt");
				}
                                
                                if (voiceCommand.equalsIgnoreCase("Open Chrome in incognito")) {
					Runtime.getRuntime().exec("cmd.exe /c Start chrome /incognito");
				}
                                
                                
                                if (voiceCommand.equalsIgnoreCase("Play tictacktoe"))
                                {
                                  mf.setVisible(true);
                                }
                                
                                
                                if (voiceCommand.equalsIgnoreCase("Seven Play Snakegame"))
                                {
                                       sg=new GameFrame();  
                                     sg.setVisible(true);
                                }
                                if (voiceCommand.equalsIgnoreCase("Seven Show time"))
                                {
                                    ck= new MyFrame();
                                    ck.setVisible(true);
                                }
                                
                                else if (voiceCommand.equalsIgnoreCase("Close game"))
                                {    sg=new GameFrame();
                                     ck= new MyFrame();
                                     tts.speak("Bye Bye", 1.0f, false, false);
                                    mf.setVisible(false);
                                    ck.setVisible(false);
                                    sg.setVisible(false);
                                    
                                //  Runtime.getRuntime().addShutdownHook(new StopThread());
                                }
                                
                                
                                 if (voiceCommand.equalsIgnoreCase("Close Program"))
                                {
                                    tts.speak("Bye Bye", 1.0f, false, false);
                                 System.exit(0);
                                }
                                 
                                
                                  if (voiceCommand.equalsIgnoreCase("Who are You"))
                                {
                                 tts.speak("I am Seven an voice assistant Version 1.3 created by aashish S N", 1.0f, false, false);
                                }
                                  
                                
                                  if (voiceCommand.equalsIgnoreCase("Book Ticket"))
                                {
                                    tts.speak("Book your tickets Here", 1.0f, false, false);
                                  ttb.setVisible(true);
                                }
                                  
                                  
                                else if (voiceCommand.equalsIgnoreCase("Seven Close"))
                                {
                                     tts.speak("Thank you For using our service", 1.0f, false, false);
                                   ttb.setVisible(false);
                                //  Runtime.getRuntime().addShutdownHook(new StopThread());
                                }
                                
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
                
              
		
		/*try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		}*/
		
		// Start recognition process pruning previously cached data.
		// recognizer.startRecognition(true);
		
		//Check if needed resources are available
		startResourcesThread();
		//Start speech recognition thread
		startSpeechRecognition();
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Starts the Speech Recognition Thread
	 */
	public synchronized void startSpeechRecognition() {
		
		//Check lock
		if (speechRecognizerThreadRunning)
			logger.log(Level.INFO, "Speech Recognition Thread already running...\n");
		else
			//Submit to ExecutorService
			eventsExecutorService.submit(() -> {
				
				//locks
				speechRecognizerThreadRunning = true;
				ignoreSpeechRecognitionResults = false;
				
				//Start Recognition
				recognizer.startRecognition(true);
				
				//Information			
				logger.log(Level.INFO, "You can start to speak...\n");
				
				try {
					while (speechRecognizerThreadRunning) {
						/*
						 * This method will return when the end of speech is reached. Note that the end pointer will determine the end of speech.
						 */
						SpeechResult speechResult = recognizer.getResult();
						
						//Check if we ignore the speech recognition results
						if (!ignoreSpeechRecognitionResults) {
							
							//Check the result
							if (speechResult == null)
								logger.log(Level.INFO, "I can't understand what you said.\n");
							else {
								
								//Get the hypothesis
								speechRecognitionResult = speechResult.getHypothesis();
								
								//You said?
								System.out.println("You said: [" + speechRecognitionResult + "]\n");
								
								//Call the appropriate method 
								makeDecision(speechRecognitionResult, speechResult.getWords());
								
							}
						} else
							logger.log(Level.INFO, "Ingoring Speech Recognition Results...");
						
					}
				} catch (Exception ex) {
					logger.log(Level.WARNING, null, ex);
					speechRecognizerThreadRunning = false;
				}
				
				logger.log(Level.INFO, "SpeechThread has exited...");
				
			});
	}
	
	/**
	 * Stops ignoring the results of SpeechRecognition
	 */
	public synchronized void stopIgnoreSpeechRecognitionResults() {
		
		//Stop ignoring speech recognition results
		ignoreSpeechRecognitionResults = false;
	}
	
	/**
	 * Ignores the results of SpeechRecognition
	 */
	public synchronized void ignoreSpeechRecognitionResults() {
		
		//Instead of stopping the speech recognition we are ignoring it's results
		ignoreSpeechRecognitionResults = true;
		
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Starting a Thread that checks if the resources needed to the SpeechRecognition library are available
	 */
	public void startResourcesThread() {
		
		//Check lock
		if (resourcesThreadRunning)
			logger.log(Level.INFO, "Resources Thread already running...\n");
		else
			//Submit to ExecutorService
			eventsExecutorService.submit(() -> {
				try {
					
					//Lock
					resourcesThreadRunning = true;
					
					// Detect if the microphone is available
					while (true) {
						
						//Is the Microphone Available
						if (!AudioSystem.isLineSupported(Port.Info.MICROPHONE))
							logger.log(Level.INFO, "Microphone is not available.\n");
						
						// Sleep some period
						Thread.sleep(350);
					}
					
				} catch (InterruptedException ex) {
					logger.log(Level.WARNING, null, ex);
					resourcesThreadRunning = false;
				}
			});
	}
	
	/**
	 * Takes a decision based on the given result
	 * 
	 * @param speechWords
	 */
	public void makeDecision(String speech , List<WordResult> speechWords) {
		
		System.out.println(speech);
		
	}
	
	public boolean getIgnoreSpeechRecognitionResults() {
		return ignoreSpeechRecognitionResults;
	}
	
	public boolean getSpeechRecognizerThreadRunning() {
		return speechRecognizerThreadRunning;
	}
	
	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}
}
