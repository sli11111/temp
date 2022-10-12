export default {

  /**
   * @type {string} build path
   */
  buildPath: 'dist',

  /**
   * @type {string} title
   * @description Title of the application
   */
  title: 'Sancho Vue3 Admin',

  /**
   * @type {boolean} true | false
   */
  debug: true,

   /**
    * @type {boolean} true | false
    * @description Whether show the logo in sidebar
    */
  sidebarLogo: true,

  /**
   * @type {string} TimeZone
   * @description Application timeZone, null means use browser.
   */
  timeZone: 'Asia/Shanghai',

  layout: {
    /**
     * @type {boolean} true | false
     * @description Whether fix the header
     */
    fixedHeader: true,

    /**
     * @type {boolean} true | false
     * @description Whether need tagsView
     */
    tagsView: true,

    /**
     * @type {boolean} true | false
     * @description Whether close sidebar at beginning
     */
    collapseSidebar: true,

    enableFullScreen: true,

    enableReboot: false
  },

  client: {

    withCredentials: true,

    timeout: 100000

  },

  theme: {

    enableAutoThemeModeDetect: false,

    defaultThemeMode: 'light'

  },

  security: {

    /**
     * @type {string} 'header' | 'cookie'
     */
    tokenStrategy: 'cookie',

    /**
     * Name for JWT
     */
    tokenKey: {

      header: 'Access-Token',

      cookie: 'ACCESS_TOKEN',

      param: 'token'

    },

    enableRequestEncryption: true,

    enableResponseDecryption: true,

    cryptoPassword: 'PMpsSFfBFjjwcP1e'
  },

  system: {

    password: {
      strongRegexp: /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[~!@#$%^&*()_+`\-={}:";'<>,.\/\|\\\[\]?]).{8,}$/,
      mediumRegexp: /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/,
      weekRegexp:   /^([A-Za-z]){8,}|([0-9]){8,}$/,
      minLength: 8,
      minPasswordScore: 33,
      encrypt: function(text) {
        return text
      }
    },

    enableSystemAlert: true,

    user: {

      /**
       * @type {boolean} true | false
       * @description Whether you can add userId to a user in user management
       */
      enableCustomId: false,

      /**
       * @type {string} 'local' | 'remote'
       * @description This determines how to read user data
       * local  - User data save local db
       * remote - Get user data through interface
       */
      mode: 'local',

      enableImpersonate: true,

      additionalParams: [
        { key: '', label: '', required: false, type: '', dict: '' }
      ]

    },

    menu: {

      /**
       * @type {string} 'backend' | 'frontend'
       * @description This determines how the application will behave when interactive with menu feature
       * backend  - Items of menu are defined at backend
       *            The menu management will show
       *            App will strictly use data from backend as menu permission tree
       * frontend - Items of menu are defined at frontend, menu management will not show
       *            The menu management will not show
       *            App will use data from routers as menu permission tree
       *            Router must be marked as menu: isMenu = true
       */
      mode: 'frontend'

    },

    perm: {

      /**
       * @type {string} 'none' | 'backend' | 'frontend' | 'mixed'
       * @description This determines how the application will behave when interactive with permission feature
       * none     - Permission mode closed
       *            Permission list will not show in role management
       * backend  - Items of permission are defined at backend
       * frontend - Items of permission are defined at frontend
       * mixed    - Items of permission are defined both at frontend and backend
       */
      mode: 'mixed'

    },

    role: {

      /**
       * @type {boolean} true | false
       * @description Whether you can add user to a role in role management
       */
      userMngOn: true

    },

    org: {

      /**
       * @type {string} 'full' | 'simple'
       * @description The organization manage mode
       * full   - Show detailed fields of organizations
       * simple - Show only the basic fields of organization (orgId, orgName)
       */
      mode: 'full',

      /**
       * @type {string} 'full' | 'simple'
       * @description The organization show name mode
       * full   - Show full name of organization (orgName)
       * simple - Show short name of organization (orgNameShort)
       */
      showName: 'simple',

      /**
       * @type {boolean} true | false
       * @description Whether you can add user to an organization in organization management
       */
      userMngOn: true,

      /**
       * @type {boolean} true | false
       * @description Whether to synchronize remote organization data
       */
      synchronize: false

    }

  }

  // =========================================================================================
  // !!! The following options cannot be overwritten by other entry settings files
  // =========================================================================================



}
