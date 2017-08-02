import scalaj.http.Http

val apiID = "616bf166-c8b5-46c2-8c16-4440e6eb7a5e"
val apiPass = "Ue4MV51UuEnwFfJVbtr6vvy"

//Http("https://login.microsoftonline.com/botframework.com/oauth2/v2.0/token")
//  .postForm(Seq(
//    "grant_type" -> "client_credentials",
//    "client_id" -> apiID,
//    "client_secret" -> apiPass,
//    "scope" -> "https://api.botframework.com/.default"
//  ))
//  .headers("Content-Type" -> "application/x-www-form-urlencoded")
//  .asString.body

val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlZXVkljMVdEMVRrc2JiMzAxc2FzTTVrT3E1USIsImtpZCI6IlZXVkljMVdEMVRrc2JiMzAxc2FzTTVrT3E1USJ9.eyJhdWQiOiJodHRwczovL2FwaS5ib3RmcmFtZXdvcmsuY29tIiwiaXNzIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvZDZkNDk0MjAtZjM5Yi00ZGY3LWExZGMtZDU5YTkzNTg3MWRiLyIsImlhdCI6MTUwMTY0NTU1NSwibmJmIjoxNTAxNjQ1NTU1LCJleHAiOjE1MDE2NDk0NTUsImFpbyI6IlkyRmdZRkIxcjVsY1V4RVFhMWFVRTN1ZS8zNG1BQT09IiwiYXBwaWQiOiI2MTZiZjE2Ni1jOGI1LTQ2YzItOGMxNi00NDQwZTZlYjdhNWUiLCJhcHBpZGFjciI6IjEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC9kNmQ0OTQyMC1mMzliLTRkZjctYTFkYy1kNTlhOTM1ODcxZGIvIiwidGlkIjoiZDZkNDk0MjAtZjM5Yi00ZGY3LWExZGMtZDU5YTkzNTg3MWRiIiwidmVyIjoiMS4wIn0.GXhJP5TM9BEOXHEVoFvq1w53X7qnBx2fc16LOj6yRCnGSRc5Ls4nbX0CHZZHHb40E8dVhaOzBsDhsU5-fyDxdxO2qA01xcwm9rbSAZaiZ24iPh8QbYLgFrIsyX_RV4BaWzUB0UALx4XXemJRWZVtPRBSSMocnGkkwgdF5CJD48VEY9r3wHYqAe1kKVutREkSUfLZUy8DwQnMvJqIoB1zzyRXTDoLIVZhGbHWHR2dlXTuqF8vV45reFxD0IHtG1_gbLfsNqJkYDRX7SaqVmM2psxHfbrQqSX3kA9ql13Pbx75Fc3r0SMzSn457GwlZiyWAEcu8mA44Ql-dw5Slre_wA"
val auth = ("Authorization", s"Bearer $token")

Http("https://smba.trafficmanager.net/apis/v3/conversations/12345/activities ")
  .headers(auth)
  .postForm.asString

//POST https://login.microsoftonline.com/botframework.com/oauth2/v2.0/token
//Host: login.microsoftonline.com
//Content-Type: application/x-www-form-urlencoded
//
//grant_type=client_credentials&
// client_id=MICROSOFT-APP-ID&
// client_secret=MICROSOFT-APP-PASSWORD&
// scope=https%3A%2F%2Fapi.botframework.com%2F.default