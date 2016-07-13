package fossilsarcheology.server.util;

public enum ReleaseType {
    DEVELOP {
        @Override
        public String getBranding() {
            return "DEV BUILD";
        }

        @Override
        public boolean enableDebugging() {
            return true;
        }
    },
    BETA {
        @Override
        public String getBranding() {
            return "PRE-RELEASE";
        }
    },
    RELEASE {
        @Override
        public String getBranding() {
            return "";
        }
    };

    public abstract String getBranding();

    public boolean enableDebugging() {
        return false;
    }

    public static ReleaseType parseVersion(String version) {
        if (version.endsWith("-develop")) {
            return DEVELOP;
        } else if (version.contains("-pre")) {
            return BETA;
        } else {
            return RELEASE;
        }
    }
}
