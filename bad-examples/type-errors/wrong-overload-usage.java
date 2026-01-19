// EXPECTED: type error - wrong method overload usage (no method f(int,int))
class WrongOverloadUsage {
  void f(int x) {}

  void test() {
    f(1, 2);
  }
}
