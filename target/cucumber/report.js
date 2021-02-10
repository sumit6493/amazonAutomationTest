$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/amazonTestCase.feature");
formatter.feature({
  "name": "verify the amazon page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search for a product and verif",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is in onBoarding screen",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeScreenSteps.userIsInOnBoardingScreen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login with valid user credentials",
  "keyword": "When "
});
formatter.match({
  "location": "HomeScreenSteps.loginWithValidUserID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to home page after successful login",
  "keyword": "And "
});
formatter.match({
  "location": "HomeScreenSteps.verifyHomePageAfterSuccessfulLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "search for 65 inch TV",
  "keyword": "And "
});
formatter.match({
  "location": "HomeScreenSteps.searchForInchTV(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select any random result from searched list",
  "keyword": "And "
});
formatter.match({
  "location": "HomeScreenSteps.selectItemFromList()"
});
formatter.result({
  "error_message": "java.lang.IndexOutOfBoundsException: Index: 3, Size: 1\n\tat java.util.ArrayList.rangeCheck(ArrayList.java:657)\n\tat java.util.ArrayList.get(ArrayList.java:433)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat io.appium.java_client.pagefactory.ElementListInterceptor.getObject(ElementListInterceptor.java:40)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfAListOfElements.intercept(InterceptorOfAListOfElements.java:49)\n\tat $java.util.ArrayList$$EnhancerByCGLIB$$b5855c01.get(\u003cgenerated\u003e)\n\tat com.amazon.steps.HomeScreenSteps.selectItemFromList(HomeScreenSteps.java:58)\n\tat ✽.select any random result from searched list(features/amazonTestCase.feature:8)\n",
  "status": "failed"
});
formatter.step({
  "name": "click on Add to cart from product detail page",
  "keyword": "And "
});
formatter.match({
  "location": "HomeScreenSteps.addToCart()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user navigates to cart page",
  "keyword": "And "
});
formatter.match({
  "location": "HomeScreenSteps.userNavigatesToCartPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user can see same product in cart page",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeScreenSteps.userCanSeeSameProductInCartPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});