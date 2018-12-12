# SimpliFile

SimpliFile is a simple Java library helping to handle folders and files. 
It's goal is to have a simple, fluent end efficient dsl to replace the complex Java file handling.
I hate File class in Java because it describe both file and directory, so in SimpliFile you there are two main classes:
* `Folder`: that describe directory
* `DiskFile`: that describe file
I choose this names to avoid  opverlaps with JDK classes.

### Prerequisites

You must have Maven

## Running the tests

```
mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **[Marco Fracassi](https://github.com/fracassi-marco)**

## License

This project is licensed under the GNU GENERAL PUBLIC LICENSE Version 3 - see the [LICENSE](LICENSE) file for details
