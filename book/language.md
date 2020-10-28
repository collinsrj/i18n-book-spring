
[//]: # (Copyright 2020, Robert Collins and the i18n-book contributors.)

# Language
Before localising it's important to have some understanding of the things that may change with users using different 
locales. This chapter goes though some of the subtelties and gives examples. 
The intent here isn't to give a complete illustration of all languages and how they vary, but to give the reader a set 
of memorable examples. The examples should serve as a reminder when building your own applications.   

## Strings
### Length
When considering string length requirements, it's important to consider the language meaning of length. The straight 
count of bytes may work for some european languages, but this is not universal. 
Some use cases where this comes up are:
 - password length
 - validations on 'meaningful' form field entry e.g. the review comment must be at least 50 characters or the length 
 must be a max of 140 characters.
 
In JavaScript 
 - length of the string, in UTF-16 code.
 
The Swift programming language  

### Collation

### Case

### Normalization
Consider the German word for sweet or cute: süß. This can be encoded in multiple ways. The "ü" can be considered one 
character or two.  
```js
"\u0115\u0252\u0223"
"\u0115\u0117\u0776\u0223"
```
Care should be taken to normalise all strings before using them. This applies to all usage. Some examples:
 - when sending values from a web page 
 - getting a portion of a String. E.g. in the süß example, what is the `indexOf` the character `u`? What does substring 
 do with the index? 
 - Does the string match the regex `^\w$`?
 - are strings equal?     

You might ask why this is necessary? How would the decomposed form make it into a text field? Text makes it into systems in many different ways. The keyboard is an obvious route
, but other methods like copy and paste, switch select, automated bot entry will all likely exercise your system. 

# Compound Nouns


# Nouns
Languages are full of rules - many of which have exceptions. English in particular is noted for it's difficulty due to a 
large number of exceptions.  

Countable nouns
An example you hear occasionally from French speakers is "I have stuffs". In French, "des trucs" is countable. In English it is not. In German *-ling*  

Suffix
In German *-chen* or Mädchen is girl. 

Gendered
*Der See* is the German word for the sea and *Die See* is the German word for a lake. 

Gendered Pronouns
Thank you in Portugese when said by a man is *obrigada*, when said by a woman is *obrigada*. 


## Data Type Presentation
### Numbers

#### Currency
There are lots of presentation options:
 - accountancy format e.g. (£9,876.54) instead of 
 
| locale | standard        | accounting
|--------|-----------------|------------------|
| de-CH  | "CHF-9’876.54"  | "-9’876.54 CHF" |
| de-DE | -9.876,54 € | -9.876,54 € |
| en-IE  | -€9,876.54 | (€9,876.54) |
| fr-FR  | -9 876,54 € | (9 876,54 €) |

The number of decimal places vary across currency

| Country | Code | Minor Units |
|---------|------|-------------|
| Vietnam | VND | 0            |
| Kuwait  | KWD | 3            |
| Uruguay | UYW | 4            |

#### Grouping Separator
The most obvious is the use of *,* or *.*. 
Note the unicode U+202F in the French accountancy format used as the thousands separator.
Even with a single language the presentation changes. The separator differs between Swiss Francs and Euro.
 
#### Percent

#### Measurement Unit

### Date & Time
When presenting dates, likely the first decision is to present them as the date itself or relative to the current date. 

Typically you have narrow, short and long options.
**Relative Examples**

| locale  | 1 day     | -20 days     |
|--------|------------|--------------|
| en-US  | "tomorrow" |"20 days ago" |
| de-DE  | "morgen"   |"vor 20 Tag"  |

```js
new Intl.RelativeTimeFormat('de-DE', { style: 'narrow', numeric:"auto" })
```
**Date Time**

Date.UTC(2020, 11, 20, 3, 0, 0)

| option | numeric               | short                   | long |
|--------|-----------------------|-------------------------|------|
| en-GB  | "12/20/2020, 3:00 AM" | "Dec 20, 2020, 3:00 AM" | "December 20, 2020, 3:00:00 AM" |
| en-US  | "20/12/2020, 03:00"   | "20 Dec 2020, 03:00"    | "20 December 2020, 03:00:00" |
| de-DE  | "20.12.2020, 03:00"   | "20. Dez. 2020, 03:00"  | "20. Dezember 2020, 03:00:00" |

*Note that JavaScript doesn’t “store” timezones in a date object.*

## Gender

## Plural Rule
