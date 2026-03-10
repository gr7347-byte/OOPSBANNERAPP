public class OopsBannerApp {

    static class CharacterPatternMap {
        private final Character character;
        private final String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        return new CharacterPatternMap[] {
                new CharacterPatternMap('O', new String[] {
                        "  **** ",
                        " * * ",
                        " * * ",
                        " * * ",
                        " * * ",
                        " * * ",
                        "  **** "
                }),
                new CharacterPatternMap('P', new String[] {
                        " ***** ",
                        " * * ",
                        " * * ",
                        " ***** ",
                        " * ",
                        " * ",
                        " * "
                }),
                new CharacterPatternMap('S', new String[] {
                        "  ***** ",
                        " * ",
                        " * ",
                        "  **** ",
                        "      * ",
                        "      * ",
                        " ***** "
                }),
                new CharacterPatternMap(' ', new String[] {
                        "        ",
                        "        ",
                        "        ",
                        "        ",
                        "        ",
                        "        ",
                        "        "
                })
        };
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (Character.toUpperCase(ch) == map.getCharacter()) {
                return map.getPattern();
            }
        }
        return getCharacterPattern(' ', charMaps);
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        for (int i = 0; i < 7; i++) {
            StringBuilder line = new StringBuilder();
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                line.append(pattern[i]).append("  ");
            }
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}