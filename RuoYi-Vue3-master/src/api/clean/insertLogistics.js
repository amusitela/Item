import request from '@/utils/request'

// 查询userLogistics列表
export function listInsertLogistics(query) {
  return request({
    url: '/clean/insertLogistics/list',
    method: 'get',
    params: query
  })
}

// 查询userLogistics详细
export function getInsertLogistics(tNum) {
  return request({
    url: '/clean/insertLogistics/' + tNum,
    method: 'get'
  })
}

// 新增userLogistics
export function addInsertLogistics(data) {
  return request({
    url: '/clean/insertLogistics',
    method: 'post',
    data: data
  })
}

// 修改userLogistics
export function updateInsertLogistics(data) {
  return request({
    url: '/clean/insertLogistics',
    method: 'put',
    data: data
  })
}

// 删除userLogistics
export function delInsertLogistics(tNum) {
  return request({
    url: '/clean/insertLogistics/' + tNum,
    method: 'delete'
  })
}
