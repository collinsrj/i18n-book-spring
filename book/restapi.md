# APIs

## A REST API
Let's take a REST API as an example. In this example we're going to look at an API first approach with the API described 
using Open API V3 Swagger. 
As a product manager responsible for this API product, one of the first considerations you'll need to make is if the API 
documentation should be localised? Unfortunately Open API V3 doesn't allow for localized descriptions of the API 
natively in the format. This isn't to say that seperate descriptions cannot be maintained. It just needs some work. 

## Example Project: Jobs API
This book comes with a worked example API. The API is described using Swagger and implemented using Spring Boot.

## Error Messages
There is an RFC for error messaging. This outlines a set of fields that can be used. 
The localization of error messages should be considered if you expect the message to be shown to end users without 
processing by the API consumer. 
Will the API be used directly? An example of this would be an API used directly from a web page e.g. Google Maps. A 
widget is placed on the page that consumes content. The `Accept-Language` request header is coming directly from the 
users browser.    

## The Database
With the database, your starting place is at installation and setup. For Postgres the steps will be:
 - crea
To support a wide range of languages, we're going to set the character set to UTF-8. We can also include information on 
collation and character type support.
```shell script
createdb -E UTF8 # --lc-collate=en_US.UTF8 --lc-ctype=en_US.UTF8
```
## Enums


## Checklist
 - Error Messages
 - Dates and times in UTC
 - Dates and times serialised in ISO format
 - Numerical values in SI units
 - String content is NFC normalised
 - Charset is UTF8
 - Strings normalized
 