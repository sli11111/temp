import CryptoJS from 'crypto-js'
import { sm3 } from 'sm-crypto'

const algorithms = {
  base64: {
    name: 'BASE64',
    encrypt(txt, opt) {
      const txt_arr = CryptoJS.enc.Utf8.parse(txt)
      return CryptoJS.enc.Base64.stringify(txt_arr)
    },
    decrypt(txt, opt) {
      const parsed_txt_arr = CryptoJS.enc.Base64.parse(txt)
      return parsed_txt_arr.toString(CryptoJS.enc.Utf8)
    }
  },
  sm3: {
    name: 'SM3',
    encrypt(txt, opt) {
      return sm3(txt)
    }
  },
  aes: {
    name: 'AES',
    availableOpts: ['password', 'iv', 'mode', 'padding', 'output'],
    defaultOpt: {
      password: '',
      iv: '',
      mode: 'CBC',
      padding: 'Pkcs7',
      output: 'Hex'
    },
    modes: ['CBC', 'CFB', 'CTR', 'ECB', 'OFB'],
    paddings: ['Pkcs7', 'AnsiX923', 'Iso10126', 'NoPadding', 'ZeroPadding'],
    outputs: ['Hex', 'Base64'],
    encrypt(txt, opt) {
      const key = CryptoJS.enc.Utf8.parse(opt.password)
      const iv  = CryptoJS.enc.Utf8.parse(opt.iv)
      const mode = CryptoJS.mode[opt.mode]
      const padding = CryptoJS.pad[opt.padding]
      // Encryption
      const srcs = CryptoJS.enc.Utf8.parse(txt)
      const encrypted = CryptoJS.AES.encrypt(srcs, key, { iv, mode, padding })
      if (opt.output === 'Hex') {
        return encrypted.ciphertext.toString()
      } else {
        return encrypted.toString()
      }
    },
    decrypt(txt, opt) {
      const key = CryptoJS.enc.Utf8.parse(opt.password)
      const iv  = CryptoJS.enc.Utf8.parse(opt.iv)
      const mode = CryptoJS.mode[opt.mode]
      const padding = CryptoJS.pad[opt.padding]
      // Decryption
      if (opt.output === 'Hex') {
        const encryptedHexStr = CryptoJS.enc.Hex.parse(txt)
        const srcs = CryptoJS.enc.Base64.stringify(encryptedHexStr)
        const decrypted = CryptoJS.AES.decrypt(srcs, key, { iv, mode, padding })
        const decryptedStr = decrypted.toString(CryptoJS.enc.Utf8)
        return decryptedStr.toString()
      } else {
        const decrypted = CryptoJS.AES.decrypt(txt, key, { iv, mode, padding })
        const decryptedStr = decrypted.toString(CryptoJS.enc.Utf8)
        return decryptedStr.toString()
      }
    }
  }
}

export const AES = algorithms.aes
export const SM3 = algorithms.sm3
export const BASE64 = algorithms.base64
