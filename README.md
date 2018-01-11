




## **IndexedWordSearch**

[![API](https://img.shields.io/badge/API-1%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=1)
[![](https://jitpack.io/v/shashkiranr/IndexedWordSearch.svg)](https://jitpack.io/#shashkiranr/IndexedWordSearch)

**`IndexedWordSearch`** This library helps index list of words to be used for search.


## **How to Use**

#### *STEP 1 - Declare dependencies in your project*

To add `IndexedWordSearch` to your project, first make sure in root `build.gradle` you have to specify the following repository and dependency:
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```groovy
	dependencies {
	        compile 'com.github.shashkiranr:IndexedWordSearch:0.0.1'
	}

```

#### *STEP 2 - Initialize IndexWordSearch and call `createIndexedWord` to create the map of list of words with indexes, to display the indexed words in log, pass true to `displayIndexedWords`*

```groovy
  IndexedWordSearchJava indexedWordSearchJava = new IndexedWordSearchJava();
```

```groovy
  indexedWordSearchJava.createIndexedWord(stringList,true);
```

#### *STEP 3 - Get the filtered results by calling `getFilteredResults`, pass the string you want search in the words as `filter` and to display the indexed words in log, pass true to `displayIndexedWords`*

```groovy
   resultStringList = indexedWordSearchJava.getFilteredResults("ANY_STRING_CHARECTER",true);
```

## ***Thats it !!***

## **License**

    MIT License

    Copyright (c) 2018 Shashi Kiran R

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
