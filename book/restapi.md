
[//]: # (Copyright 2020, Robert Collins and the i18n-book contributors.)

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

## Money
Money types exist across relational databases e.g. [Postgres Monetary Type](https://www.postgresql.org/docs/9.1/datatype-money.html)
In this case, this should be avoided if the goal is to consistently store monetary amounts in different currencies as 
the precision is based on the database `lc_monetary` setting. The formatting into strings is best left up to the client 
and parsing is likely best handled on the server.
Scale and precision depend on your use case and the currencies which will be supported. To support US GAAP, a
setting something like decimal(13, 4) should be plenty for most use cases.   

## Open API v3
The spec gives an easy means to specify 
Care should be taken when specifying the JSON model. In particular:
 - pattern validations
 - length validations
Both of these can vary with the language the client or server is implemented in. 
`\d` may validate ASCII digits `[0-9]`. Similarly `\w` may only match with  

## Checklist
 - Error Messages
 - Dates and times in UTC
 - Dates and times serialised in ISO format
 - Numerical values in SI units
 - Money values use `BigDecimal` with currency appropriate scale and precision.
 - String content is NFC normalised
 - Charset is UTF8
 - Strings normalized
 