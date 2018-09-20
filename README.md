# Design Patterns Java

Design Patterns in Java from a practical perspective.

## Getting Started

Project that use design patterns of the famous book Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, John Vlissides, Ralph Johnson and Richard Helm (who are commonly known as a Gang of Four, hence the GoF acronym).

The original book was written using C++ and Smalltalk as examples.

### Prerequisites

1. Install docker
2. Install IDE
3. Define JDK in the IDE

### Installing

First we build the image

```
docker build -t javajdk:14 .
```

Run the container in background
```
docker run -d --name javajdk javajdk:14
```

Copy the JDK in the "jdk" folder
```
docker cp javajdk:jdk.tar.gz jdk
```

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Docker](https://docs.docker.com/install/) - To take the jdk

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **David Garcia** - *Just fun* - [aspicas](https://github.com/aspicas)

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/aspicas/JavaDesignPatterns/blob/master/LICENSE) file for details

