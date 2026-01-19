# bad-examples (intentionally invalid Java fixtures)

## Purpose

This folder contains **intentionally invalid** Java source files used as a **parser/linter testbed**.

- These fixtures are stored in-repo for repeatable tooling/tests.
- They are **excluded from Gradle compilation** (they are **not** part of any Gradle `sourceSet`) so normal builds/tests continue to pass.

**These files do not compile by design.**

## Organization (categories)

Fixtures are organized by the primary kind of failure they are meant to trigger:

- `parse-errors/`: **syntactically invalid** Java; a Java parser should fail.
- `type-errors/`: **syntactically valid** Java that fails type checking / symbol resolution.
- `package-module-errors/`: **syntactically valid** Java with package/path/module-style issues (as applicable).

## Conventions

To keep enumeration reliable and failures easy to understand:

### Naming

Use descriptive filenames in **kebab-case** (recommended):

- Good: `unterminated-string-literal.java`, `missing-return-statement.java`
- Avoid: `test1.java`, `bad.java`

### Required header comment

Each `.java` fixture must start with a **single-line header comment** describing the intended failure.

Example:

```java
// EXPECTED: Unterminated string literal
class UnterminatedString {
    String s = "oops;
}
```

### Keep fixtures minimal

- Keep each fixture small and **single-purpose**.
- Prefer **one primary failure per file** (avoid bundling multiple unrelated failures together).

## Enumeration guidance (for tooling)

- Tooling should treat `bad-examples/**/*.java` as fixtures.
- Tooling must **not** assume these files compile.
- Enumeration is expected to be done by walking the `bad-examples/` subfolders; **no Gradle integration is expected**.
