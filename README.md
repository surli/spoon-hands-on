# Spirals Seminar's Spoon hands on!

This repository contains the material for a tutorial around the usage of [Spoon](http://github.com/INRIA/spoon). 

## How to compile?

I provided all necessary dependencies with the project to be able to compile/run it offline.
You can either use the provided maven wrapper (:warning: you might experience issues with JEnv on MacOS) or use a standard maven tool. 

### With Maven Wrapper (easiest way)

```bash
./mvnw clean package
```

(by default, the operation is done offline.)

### With Maven standard tool (in case of problem with Maven Wrapper)

```bash
mvn -gs m2-settings.xml -o clean package
```

The first option tells maven to use the specified local repository to avoid downloading again the dependencies. The second one is to tell maven to work offline.

## Repository organization

The repository contains two modules: 
  1. demoproject
  2. processors
  
### demoproject

This module contains a Java project playing with counters. It provides a public API and a private one through package names.
The idea here is not to provide an usable project, but really to have some material on which we can apply transformations.

The `pom.xml` of this project contains a configuration to run a Spoon processor when generating sources during the Maven process.

### processors

This module contains some material illustrating Spoon usage.
It contains two packages:
  - `launcher`: contains a class with a main method to show the usage of Spoon Launcher API with some option. It can be called directly to use the processors
  - `processor`: contains the code of different processors with different goals. New processors should be added as new classes.
  
