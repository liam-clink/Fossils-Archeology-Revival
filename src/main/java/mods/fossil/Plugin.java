package mods.fossil;

public interface Plugin
{
    enum WikiType
    {
        MEDIAWIKI, WIKIA, DOKUWIKI, CUSTOM
    }

    /** Is this plugin available for WikiLink
     *  to use?
     *
     *  true/false
     *
     *  @since 1.6.2-011
     */
    public boolean isAvailable();

    /** Please enter the @modid value here.
     *  It's not used yet, but it will be used
     *  for NEI integration in a later update.
     *
     *  @since 1.6.2-011
     */
    public String getModID();

    /** This is the "code" to access your wiki.
     *  /wiki <key> <query>
     *
     *  @since 1.6.2-010
     */
    public String getWikiKey();

    /** This is the english name of your wiki.
     *  "Example Wiki"
     *
     *  @since 1.6.2-010
     */
    public String getWikiName();

    /** This is the domain name of your wiki.
     *  "wiki.example.com"
     *
     *  Please do not add any slashes!
     *
     *  @since 1.6.2-010
     */
    public String getWikiDomain();

    /** This is the software name of your wiki.
     *  "MEDIAWIKI","DOKUWIKI","WIKIA","WIKISPACES","PHPWIKI"
     *
     *
     *  You can create a custom one, just follow the
     *  instructions on the forum post.
     *
     *  @since 1.6.2-010
     */
    public String getWikiSoftware();

    /** You can create a custom wiki software.
     *  enum WikiType = CUSTOM;
     *
     *  Paste in the search domain here
     *  ex: "/index.php?search="
     *
     *  @since 1.6.2-011
     */
    public String getCustomWikiSearchFormat();
}
