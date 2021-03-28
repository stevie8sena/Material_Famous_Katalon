import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def DataRegister = findTestData('Data Files/Material_Famous/DataRegister')

Mobile.startExistingApplication('com.sourcey.materialloginexample', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Material_Famous/url_create_account'), 0)

for (def index : (1..5)) {
    Mobile.setText(findTestObject('Material_Famous/txt_name'), 'Sena', 0)

    Mobile.setText(findTestObject('Material_Famous/txt_address'), 'Yogyakarta', 0)

    Mobile.setText(findTestObject('Material_Famous/txt_mail'), DataRegister.getValue('email', index), 0)

    Mobile.setText(findTestObject('Material_Famous/txt_mobile_number'), '0887654321', 0)

    Mobile.setText(findTestObject('Material_Famous/txt_password'), DataRegister.getValue('password', index), 0)

    Mobile.setText(findTestObject('Material_Famous/txt_password_re'), DataRegister.getValue('passwordre', index), 0)

    Mobile.tap(findTestObject('Material_Famous/btn_create_account'), 0)
}

if (Mobile.verifyElementText(findTestObject('Material_Famous/textView_Hello_world'), 'Hello world!')) {
    Mobile.pressHome()
}

