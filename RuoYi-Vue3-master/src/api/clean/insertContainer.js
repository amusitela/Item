import request from '@/utils/request'


// 查询userContainer列表
export function listInsertContainer(query) {
  return request({
    url: '/clean/insertContainer/list',
    method: 'get',
    params: query
  })
}

// 查询userContainer详细
export function getInsertContainer(num) {
  return request({
    url: '/clean/insertContainer/' + num,
    method: 'get'
  })
}

// 新增userContainer
export function addInsertContainer(data) {
  return request({
    url: '/clean/insertContainer',
    method: 'post',
    data: data
  })
}

// 修改userContainer
export function updateInsertContainer(data) {
  return request({
    url: '/clean/insertContainer',
    method: 'put',
    data: data
  })
}

// 删除userContainer
export function delInsertContainer(num) {
  return request({
    url: '/clean/insertContainer/' + num,
    method: 'delete'
  })
}
