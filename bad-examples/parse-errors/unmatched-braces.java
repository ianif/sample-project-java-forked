// EXPECTED: parse error - unmatched braces (missing closing brace)
class UnmatchedBraces {
  void f() {
    if (true) {
      int x = 1;
  }
}
