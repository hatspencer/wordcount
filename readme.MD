## iteration-3

An additional integration test to cover the file reading would be sensible, but was skipped in favor of continuing with further iterations.

It is possibly not great that I need to change the access modifiers of my methods in order to make them testable.

The final test covering reading input from a file was somewhat unclear to me on how to write it, which could suggest that some kind of refactor would help to make the file reading and the file contents to input string conversion separably testable.

After discussion with Bernhard, it would be better (both for testing and as general approach) to separate logic across more classes.