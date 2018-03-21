#include <string>
#include <iostream>

std::string hello () {
  return std::string("hello world");
}

int main () {
  std::string h = hello();
  std::cout << h << std::endl;
  return 0;
}
