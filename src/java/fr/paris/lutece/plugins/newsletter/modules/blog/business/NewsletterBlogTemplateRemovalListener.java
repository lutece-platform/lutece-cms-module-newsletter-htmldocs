package fr.paris.lutece.plugins.newsletter.modules.blog.business;

import fr.paris.lutece.plugins.newsletter.service.NewsletterPlugin;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.util.RemovalListener;

import java.util.Locale;

/**
 * Removal listener for templates used by newsletters
 */
public class NewsletterBlogTemplateRemovalListener implements RemovalListener
{
    private static final String MESSAGE_TEMPLATE_USED_BY_NEWSLETTER = "module.newsletter.blog.message.templateUsedByDocumentTopic";

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canBeRemoved( String strId )
    {
        return !NewsletterBlogHome.findTemplate( Integer.parseInt( strId ), PluginService.getPlugin( NewsletterPlugin.PLUGIN_NAME ) );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRemovalRefusedMessage( String id, Locale locale )
    {
        return I18nService.getLocalizedString( MESSAGE_TEMPLATE_USED_BY_NEWSLETTER, locale );
    }

}
