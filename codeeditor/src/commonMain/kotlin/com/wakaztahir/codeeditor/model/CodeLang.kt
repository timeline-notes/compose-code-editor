package com.wakaztahir.codeeditor.model

enum class CodeLang(val value: Array<String>) {
    Default(arrayOf("default-code", "default-markup")),
    HTML(arrayOf("default-markup")),
    C(arrayOf("c")),
    CPP(arrayOf("cpp")),
    ObjectiveC(arrayOf("cxx")),
    CSharp(arrayOf("cs")),
    Java(arrayOf("java")),
    Bash(arrayOf("bash")),
    Python(arrayOf("python")),
    Perl(arrayOf("perl")),
    Ruby(arrayOf("ruby")),
    JavaScript(arrayOf("javascript")),
    CoffeeScript(arrayOf("coffee")),
    Rust(arrayOf("rust")),
    Appollo(arrayOf("apollo")),
    Basic(arrayOf("basic")),
    Clojure(arrayOf("clj")),
    CSS(arrayOf("css")),
    Dart(arrayOf("dart")),
    Erlang(arrayOf("erlang")),
    Go(arrayOf("go")),
    Haskell(arrayOf("hs")),
    Lisp(arrayOf("lisp")),
    Llvm(arrayOf("llvm")),
    Lua(arrayOf("lua")),
    Matlab(arrayOf("matlab")),
    ML(arrayOf("ml")),
    OCAML(arrayOf("ml")),
    SML(arrayOf("ml")),
    FSharp(arrayOf("fs")),
    Mumps(arrayOf("mumps")),
    N(arrayOf("n", "nemerle")),
    Pascal(arrayOf("pascal")),
    R(arrayOf("r", "s", "R", "S", "Splus")),
    Rd(arrayOf("Rd", "rd")),
    Scala(arrayOf("scala")),
    SQL(arrayOf("sql")),
    Tex(arrayOf("latex", "tex")),
    VB(arrayOf("vb", "vbs")),
    VHDL(arrayOf("vhdl", "vhd")),
    Tcl(arrayOf("tcl")),
    Wiki(arrayOf("wiki.meta")),
    XQuery(arrayOf("xq", "xquery")),
    YAML(arrayOf("yaml", "yml")),
    Markdown(arrayOf("md", "markdown")),
    JSON(arrayOf("json")),
    XML(arrayOf("xml")),
    Proto(arrayOf("proto")),
    RegEx(arrayOf("regex"))

}