#include<iostream>#include<vector>#include<string>

class CharacterPatternMap {
    private:
    char character;[cite:52,106]std::vector<std::string>pattern;[cite:53,108]

public:
    CharacterPatternMap(char ch, std::vector<std::string> pat) 
        : character(ch), pattern(pat) {} [cite: 21, 116]

    char getCharacter() const { return character; } [cite: 24, 122]
    std::vector<std::string> getPattern() const { return pattern; } [cite: 24, 127]
};

    std::vector<CharacterPatternMap> createCharacterPatternMaps() {
    std::vector<CharacterPatternMap> maps; [cite: 28, 58]

    maps.push_back(CharacterPatternMap('O', {
        "  **** ",
        " * * ",
        " * * ",
        " * * ",
        " * * ",
        " * * ",
        "  **** "
    })); [cite: 11, 59]

    maps.push_back(CharacterPatternMap('P', {
        " ***** ",
        " * * ",
        " * * ",
        " ***** ",
        " * ",
        " * ",
        " * "
    })); [cite: 11, 59]

    maps.push_back(CharacterPatternMap('S', {
        "  ***** ",
        " * ",
        " * ",
        "  **** ",
        "      * ",
        "      * ",
        " ***** "
    })); [cite: 11, 59]

    maps.push_back(CharacterPatternMap(' ', {
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "        "
    })); [cite: 45, 59]

    return maps; [cite: 60]
}

    std::vector<std::string>

    getCharacterPattern(char ch, const std::vector<CharacterPatternMap>& charMaps) {
    for (const auto& map : charMaps) {
        if (toupper(ch) == map.getCharacter()) {
            return map.getPattern(); [cite: 65, 147]
        }
    }
    return getCharacterPattern(' ', charMaps); [cite: 148, 152]
}

void printMessage(std::string message, const std::vector<CharacterPatternMap>& charMaps) {
    for (int i = 0; i < 7; ++i) { [cite: 10, 139]
        for (char ch : message) { [cite: 68]
            std::vector<std::string> pattern = getCharacterPattern(ch, charMaps); [cite: 46, 156]
            std::cout << pattern[i] << "  "; [cite: 160]
        }
        std::cout << std::endl;
    }
}

int main() {
    std::vector<CharacterPatternMap> charMaps = createCharacterPatternMaps(); [cite: 190, 193]
    std::string message = "OOPS"; [cite: 194]
    printMessage(message, charMaps); [cite: 195]
    return 0;
}