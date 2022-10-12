import { MockMethod } from 'vite-plugin-mock'

export default [
  {
    url: `/common/dicts`,
    method: 'get',
    statusCode: 200,
    response: () => {
      return {
        flag: 0,
        data: { 
          "REQUEST_RESULT": {
            "SUCCESS":"成功",
            "FAIL":"失败"
          }
        },
        message: null
      }
    }
  }
] as MockMethod[]
