package com.github.revival.common.handler;

/**
 * TAKEN FROM <a href='https://github.com/iLexiconn/LLibrary/'></a>
 *
 * @author iLexiconn
 * @since 0.2.0
 */
public class ContentHelper
{
    /**
     * @since 0.2.0
     */
    public static void init(IContentHandler... contentHandlers)
    {
        for (IContentHandler contentHandler : contentHandlers)
        {
            try
            {
                contentHandler.init();
                contentHandler.gameRegistry();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
