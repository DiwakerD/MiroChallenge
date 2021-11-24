### **Pre-requisite-Machine must have JDK 1.8 or Greater**

**Project Technology Stack :** - Java,JavaScript,TestNG,Selenium,ExtentReport.

**About the Project:**

****Package:main.java.org.miro.pages****
1. **PageClass** -Its an Abstract Type of Class where the Common Methods are defined.

2. **BasePage Class** -It is a Child Class of PageClass & Implements its method.

3. **LoginPage**-These are child class of BasePage class. They follow the
   principle of POM, Hence all the Elements of the Respective WebPage & Methods are defined in these Classes.

****Package:main.java.org.miro.utilities****
1. **TestUtility** -All the utility methods are defined in this class.

2. **config.properties**- URL & Password related Details are defined in this file.

****Package:main.java.org.miro.testClasses****
1. **BaseTest**- It is a Class where all the Before & After Test Methods are defined. It is the Parent Class of All other Test
Classes

2. **SignUpWithValidCredentialsTest**- All the Sunny Day Scenario are covered in this Test Class.

3. **SignUpWithoutCredentialsTest**- All the Negative Scenarios are covered in this Test Class.

**_An Execution Report of Successful Execution with ScreenShots named as Report.html is Already there in the Project for
Reference._**

****_Recommendation :_**** It is Recommended to Disconnect the VPN Before Running the Test Since Some Utilities Does not
Work On VPN.

**# **Steps to Run the Project :****

1. Import the Project to the Editor e.g., IntelliJ or Eclipse and compile it using mvn command 'mvn clean install -Dmaven.test.skip=true -DskipTests'

2. Go to "testng.xml" and run it. 

3. All the Test will Start Running in Parallel Mode.

4. Once the Execution is done, Open "Report.html" to check the Details of the Latest Execution.

