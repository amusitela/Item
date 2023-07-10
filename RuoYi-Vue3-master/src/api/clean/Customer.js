import request from '@/utils/request'


// 查询Customer列表
export function listCustomer(query) {
  return request({
    url: '/clean/Customer/list',
    method: 'get',
    params: query
  })
}

// 查询Customer详细
export function getCustomer(num) {
  return request({
    url: '/clean/Customer/' + num,
    method: 'get'
  })
}

// 新增Customer
export function addCustomer(data) {
  return request({
    url: '/clean/Customer',
    method: 'post',
    data: data
  })
}

// 修改Customer
export function updateCustomer(data) {
  return request({
    url: '/clean/Customer',
    method: 'put',
    data: data
  })
}

// 删除Customer
export function delCustomer(num) {
  return request({
    url: '/clean/Customer/' + num,
    method: 'delete'
  })
}
