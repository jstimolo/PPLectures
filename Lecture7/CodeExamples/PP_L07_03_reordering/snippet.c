// https://gcc.godbolt.org/z/nVVQjT
//
// Compile with gcc -O0 -o ao0.exe snippet.c, 
// then use Snowman disassembler to inspect C code (search for "result").
// Compile again with gcc -O3 -o ao3.exe snippet.c, disassemble and compare.

int result;
int done = 0;
int something;

void bar() {
  result = something + done;
  done = 1;
}

int main() {
  return 1;
}
