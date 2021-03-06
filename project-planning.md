# jBasics Project Planning

ProjectManager : Stephan Schlöpke
Developers : Stephan Schlöpke


Here I list the planned changes and any idea useful for the development of jBasics.


## Changes wich are requested.todo

- RangeSequence (monoton, isoton and antiton)
- IS8601 parser and tools (date/time check with jodan?)
- Date to the command parsing system @done
- CSV to ColumnMatrix Reader and vise versa + ValueTypeAdapter
- Extend arbitrary math (go towards strategy impl.)
- NormalDistribution (in arbitrary math)
- ValueTypeFactory registry
- Date and Time utilities (java.util.Date)
- Histogram functions
- Historical change
- Timeline abstraction (value change over time)
- Interpolation Curve
	- Backward constant interpolation
	- Forward constant interpolation
	- Linear interpolation
	- Spline interpolation
	- Open adapter to add interpolation methods
- Matrix extension for meta information (row, col, cell) and visitor Transformer


## Things to do before release 1.0.todo

- jUnit test coverage of at least 90%
- JavaDoc for all interfaces and most classes (goal is to get 90% of all classes and 100% of th interfaces including abstract classes)
- Remove all constructors and replace them by static factory methods (is this really wise? Need to be thought about).
- Everything is tag annotated if it is immutable and thread safe.


## Architecture ideas

- Try to make everything immutable
- Those types which cannot be made immutable move them to instabil packages to mark this clearly
- Check if something is clearly thread safe by creating helper for the annotation checking.
- Think about how to implement things by using compile time annotations
- Rework the XML build parser architecture
- Rework/finish the arbitrary math architecture

