
[//]: # (Copyright 2020, Robert Collins and the i18n-book contributors.)

# Engineers

## Systems Integration
When interfacing with other systems care needs to be taken to ensure the way Strings are represented are well 
understood. When interfacing with a C API are strings passed appropriately?

## Operations
UTF-8 is great for English speaking natives. We get ASCII sized memory and disk usage with the claim that we support all 
languages. 

## Deployment Packaging
There is a duty of care to ensure the products you output are performant. Poorly performing applications are wasteful 
for everybody and have been shown time and again to reduce engagement. Bundling the kitchen sink is unlikely to make 
your users very happy.
 
Use a CDN
Make resources cachable
Optimise your images 
https://crisp.chat/blog/fastest-live-chat/

For native applications like those for iOS and Android, the platform dictates how applications are bundled. 

## Checklist
 - are all strings normalised before use?
 - have all regular expression usages been checked? Can static analysis tooling be put in place to prevent errors?
 - have engineers completed education around use of string functions?
 - are operating systems provisioned with necessary libraries like ICU? `apt-get install -y libicu-dev`
 - are the appropriate operating systems language packs installed?
