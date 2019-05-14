/**
 * Define all of your application routes here
 * for more information on routes, see the
 * official documentation https://router.vuejs.org/en/
 */

export default [
  {
    path: '/',
    // Relative to /src/views
    view: 'Home'
  },
  {
    path: '/about',
    name: 'About',
    view: 'About'
  },
  {
    path: '/history',
    name: 'History',
    view: 'History'
  },
  {
    path: '/amenity',
    name: 'Amenity',
    view: 'Amenity'
  },
  {
    path: '/tv-upcoming',
    name: 'TV Upcoming',
    view: 'TVUpcoming'
  },
  {
    path: '/tv-unschedule',
    name: 'TV Unschedule',
    view: 'TVUnschedule'
  },
  {
    path: '/tv-contentpast',
    name: 'TV Content Past',
    view: 'TVContentPast'
  },
  {
    path: '/tv-movieupcoming',
    name: 'TV Movie Upcoming',
    view: 'TVMovieUpcoming'
  },
  {
    path: '/tv-actor',
    name: 'TV Actor',
    view: 'TVActor'
  },
  {
    path: '/tv-synonym',
    name: 'TV Synonym',
    view: 'TVSynonym'
  },
  {
    path: '/genie-music',
    name: 'Genie Music',
    view: 'GenieMusic'
  },

  {
    path: '/room',
    name: 'Room',
    view: 'Room'
  },
  {
    path: '/giga-genie-utterance',
    name: 'Giga Genie Utterance',
    view: 'GigaGenieUtterance'
  },

  {
    path: '/icons',
    view: 'Icons'
  },
  {
    path: '/contact',
    view: 'Maps'
  },
  {
    path: '/notifications',
    view: 'Notifications'
  },
  {
    path: '/upgrade',
    name: 'Upgrade to PRO',
    view: 'Upgrade'
  },
  {
    path: '/management/hetel',
    name: 'Hotel Management',
    view: 'HotelManager'
  },
  {
    path: '/management/room',
    name: 'Room Management',
    view: 'Room Manager'
  },
  {
    path: '/management/facility',
    name: 'Facility Management',
    view: 'FacilityManager'
  },      
  {
    path: '/management/amenity',
    name: 'Amenity Management',
    view: 'AmenityManager'
  },
  {
    path: '/management/information',
    name: 'Information Management',
    view: 'InformationManager'
  },
  {
    path: '/login',
    name: 'Login',
    view: 'Login'
  },

]
