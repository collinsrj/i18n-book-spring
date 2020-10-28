
[//]: # (Copyright 2020, Robert Collins and the i18n-book contributors.)

## UTF-8
Throughout the book we are going to mark all character sets as UTF-8. The ability to support all languages ensures you 
will have the ability to bring your application to any locale you'd like. 
If you're not convinced this is useful, I'd highly recommend reading the [UTF-8 Manifesto](https://utf8everywhere.org)  

## Normalize
To see the unicode characters used in a string, the following JavaScript is useful. 
```js
const strNfc = "Hähnchen".normalize('NFD');
let str = "";
for (let i = 0; i < strNfc.length; i++) {
  str += "\t";
  str += `000${strNfc.charCodeAt(i)}`.slice(-4);  
}
console.log(str)
```