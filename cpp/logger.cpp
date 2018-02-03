#include <iostream>

namespace Logger {
    void info(std::string output) {
        std::cout << "\033[0;36m[info] " << output << "\033[0m\n";
    }

    void debug(std::string output) {
        std::cout << "\033[0;32m[debug] " << output << "\033[0m\n";
    }

    void error(std::string output) {
        std::cerr << "\033[1;31m[error] " << output << "\033[0m\n";
    }
}

int main() {
    Logger::info("Hello, world!");
    Logger::debug("Attempting 'INSERT'...");
    Logger::error("Error inserting");
    return 0;
}
