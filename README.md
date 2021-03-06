Sulong
=======

Sulong (Graal LLVM) is an interpreter for LLVM IR written in
Java using the Truffle language implementation framework and Graal as a
just-in-time (JIT) compiler.

The project bases on the LLVM IR parser of the
[llvm-ir-editor project](https://github.com/amishne/llvm-ir-editor)
by Alon Mishne.

How to get started?
-------------------
First download mx, which is the build tool used by Sulong:

    git clone https://github.com/graalvm/mx
    export PATH=$PWD/mx:$PATH

Then, use mx to clone the Sulong project and its dependencies:

    git clone https://github.com/graalvm/sulong

Next, build the project:

    cd sulong
    mx build

The mx tool will ask you to choose between its server and jvmci
configuration. For now, just select server. You can read the differences
between the configurations on
https://wiki.openjdk.java.net/display/Graal/Instructions. The first
build will take some time because mx has not only to build Sulong,
but also its dependencies and the Graal LLVM.

Now, Sulong is ready to start. You can, e.g., compile a C file named
`test.c` (see further below) with mx and then use Sulong to execute it:

    mx su-clang -S -emit-llvm -o test.ll test.c
    mx su-run test.ll

If you want to use the project from within Eclipse, use the following
command to generate the Eclipse project files (there is also mx ideinit
for other IDEs):

    mx eclipseinit

If you want to inspect the command line that mx generates for a mx
command you can use the -v flag.


From where does the project name originate?
-------------------------------------------
Sulong is the romanization of the Chinese term "速龙" (Velocisaurus).
The first character translates as fast, rapid or quick, while the second
character means dragon. A literal translation of the name giving Chinese
term is thus "fast dragon". The name relates to the
[LLVM logo](http://llvm.org/Logo.html) which is a dragon (more
specifically a wyvern), and is also in line with the LLVM Dragonegg
project.

What is LLVM?
-------------
LLVM is an umbrella project for a modular and reusable compiler
infrastructure written in C++. It includes a compiler frontend `clang`
for compiling C, C++, Objective C and Objective C++ to LLVM bitcode IR.
Many of the other tools such as the optimizer `opt`, assembler,
linker, and backends then operate on the LLVM IR, to finally produce
machine code. LLVM envisions that transformations and analyses can be
applied during compile-time, link-time, runtime, and offline.

What is LLVM IR?
----------------
LLVM IR is a language that resembles assembler, but which provides
type-safety and has virtual registers that are in Static Single
Assignment (SSA) form.

Consider the following C program:
```C
#include <stdio.h>

int main() {
 printf("Hello World \n");
}
```

When compiling the C file with Clang to human readable LLVM IR with
`clang -O3 -S -emit-llvm -o test.ll test.c` and looking at the `test.ll`
file, one can see a LLVM IR program that looks similar to the following:

```
; ModuleID = 'test.c'
target datalayout = "e-p:64:64:64-i1:8:8-i8:8:8-i16:16:16-i32:32:32-
	i64:64:64-f32:32:32-f64:64:64-v64:64:64-v128:128:128-a0:0:64-
	s0:64:64-f80:128:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

@.str = private unnamed_addr constant [14 x i8]
	c"Hello World \0A\00", align 1
@str = internal constant [13 x i8] c"Hello World \00"

define i32 @main() nounwind uwtable {
  %puts = tail call i32 @puts(i8* getelementptr inbounds
	([13 x i8]* @str, i64 0, i64 0))
  ret i32 0
}

declare i32 @puts(i8* nocapture) nounwind
```
The file contains a `datalayout` and `triple` that specifies how data
should be laid out in memory, and which architecture should be targeted
in the backend. One can also see global the global variables `@.str` and
`@str`, the ``@main` function as an entry to the program, and the
`@puts` function declaration that refers to the C standard library
`puts` function.


What is Truffle?
----------------
[Truffle](https://github.com/graalvm/truffle) is a language 
implementation framework written in Java. It allows language designers
to implement a (host) language as an Abstract Syntax Tree (AST)
interpreter. Additionally, Truffle provides many language independent
facilities to the host language such as profiling, debugging, and 
language interoperability. When a Truffle AST is executed often and then
JIT-compiled with Graal, Graal can exploit its knowledge about the
Truffle framework and produce efficient machine code. Normally, the
Truffle implementation can also run on any other JVM. 
However, Truffle LLVM relies on the Foreign Function Interface (FFI) of
Graal to provide native interoperability (e.g., to call the native
malloc) and thus has a direct dependency on Graal.

What is Graal?
-------------
Graal is a JIT compiler written in Java that receives Java bytecode as
an input and produces machine code. Currently, Graal is an alternative
to the C1 and C2 compilers of the HotSpot VM. The term GraalVM refers to
a HotSpot VM using Graal as its JIT compiler. Graal's focus is on
speculative optimizations, while it also provides an advanced partial
escape analysis.

How can I trace compilation?
----------------------------
You can enable textual notifications about compilations:
```
mx su-run <file> -Dgraal.TraceTruffleCompilation=true
```

To visualize Graal's graphs you can use the Ideal Graph Visualizer:
```
mx igv
mx su-run <file> -Dgraal.Dump=
```


Further Information
-------------------
The parser of the project bases on the LLVM IR editor plugin for Eclipse
by [Alon Mishne](https://github.com/amishne/llvm-ir-editor).

The logo was designed by 
[Valentina Caruso](https://www.behance.net/volantina).

Links:
* LLVM IR: http://llvm.org/docs/LangRef.html
* Instructions to build Graal:
	https://wiki.openjdk.java.net/display/Graal/Instructions
* Truffle and Graal publications, presentations, and videos:
	https://wiki.openjdk.java.net/display/Graal/Publications+and+Presentations
