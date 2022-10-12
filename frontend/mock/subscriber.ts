import { MockMethod } from 'vite-plugin-mock'

export default [
  {
    url: `/login`,
    method: 'post',
    statusCode: 200,
    response: () => {
      return {
        "flag":0,
        "data": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbmJyYXUiLCJuYmYiOjE2MzAxMjA4MzcsImlzcyI6IkFSSy1GcmFtZXdvcmsiLCJwZXJtcyI6WyJuZXh0Y2xvdWQiLCJTVVBFUl9BRE1JTiIsIm54LWFkbWluIiwiamVua2lucy1hZG1pbiIsImplbmtpbnMtdXNlciIsImdpdGxhYi1hZG1pbiIsInZwbi11c2VyIl0sImlhdCI6MTYzMDEyMDgzNywianRpIjoiNXJTTFY1RU0ifQ.uTgWoFVzzK5VzzXf6XzGmQJf2ksIr-L2eC_dBh-4_W4",
        "msg": null,
        "meta": {
          "globalTraceNumber": null,
          "version": null,
          "requestTime": null,
          "responseTime": null
        }
      }
    }
  }
] as MockMethod[]
