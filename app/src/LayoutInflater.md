1. 
     * Inflate a new view hierarchy from the specified xml resource. Throws
     * {@link InflateException} if there is an error.
     *

  - @param resource ID for an XML layout resource to load (e.g.,

          <code>R.layout.main_page</code>)

  - @param root Optional view to be the parent of the generated hierarchy (if

         <em>attachToRoot</em> is true), or else simply an object that
          provides a set of LayoutParams values for root of the returned
          hierarchy (if <em>attachToRoot</em> is false.)

  - @param attachToRoot Whether the inflated hierarchy should be attached to

           the root parameter? If false, root is only used to create the
           correct subclass of LayoutParams for the root view in the XML.
  - @return The root View of the inflated hierarchy. If root was supplied and
              attachToRoot is true, this is root; otherwise it is the root of
              the inflated XML file.
