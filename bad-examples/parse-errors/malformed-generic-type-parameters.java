// EXPECTED: parse error - malformed generic type parameter list
import java.util.List;

class MalformedGenericTypeParameters {
  List<String>> xs;
}
