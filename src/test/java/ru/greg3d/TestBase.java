package ru.greg3d;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import ru.greg3d.applogic.implementations.*;
import ru.greg3d.applogic.interfaces.*;

//import com.microsoft.sqlserver.jdbc.*;

@Listeners({TestBase.LogListener.class})
public class TestBase {
	
	protected ApplicationManager app;

	protected static Logger LOG = LoggerFactory.getLogger(TestBase.class);

	//@BeforeSuite
	//@BeforeTest
	@Parameters({"capabilities"})
	public void SuiteSetup(String capabilities) {
		app = new ApplicationManager1(capabilities);
	}
	
	@BeforeTest
	public void SuiteSetup() {
		//app = new ApplicationManager1("JIAYU G4S");
		//app = new ApplicationManager1("android_browser");
		app = new ApplicationManager1("android_chrome");
		//app = new ApplicationManager1("firefox");
		//app = new ApplicationManager1("chrome");
	}	
	
	//@AfterSuite(alwaysRun = true)
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		app.stop();
	}
	
	public static class LogListener implements IInvokedMethodListener{

		@Override
		public void afterInvocation(IInvokedMethod m, ITestResult res) {
//			LOG.info("<<< @Test " + m.getTestMethod().getMethodName());
			
			String logResult = String.format("<<< @Test [%2s] delay: %2d ms",m.getTestMethod().getMethodName(),(m.getTestResult().getEndMillis() - m.getTestResult().getStartMillis()));
			
			switch(m.getTestResult().getStatus()){
			case 2:
				LOG.error(logResult + " <<< failed");
				break;
			case 3:
				LOG.warn(logResult + " <<< skipped");
				break;
			default:
				LOG.info(logResult + " <<< passed");
				break;
			}
		}

		@Override
		public void beforeInvocation(IInvokedMethod m, ITestResult res) {
			LOG.info(">>> @Test " + m.getTestMethod().getMethodName());
		}
	}
}
