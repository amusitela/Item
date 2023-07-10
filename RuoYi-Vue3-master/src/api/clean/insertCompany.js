import request from '@/utils/request'


// 查询userCompany列表
export function listInsertCompany(query) {
  return request({
    url: '/clean/insertCompany/list',
    method: 'get',
    params: query
  })
}

// 查询userCompany详细
export function getInsertCompany(companyNum) {
  return request({
    url: '/clean/insertCompany/' + companyNum,
    method: 'get'
  })
}

// 新增userCompany
export function addInsertCompany(data) {
  return request({
    url: '/clean/insertCompany',
    method: 'post',
    data: data
  })
}

// 修改userCompany
export function updateInsertCompany(data) {
  return request({
    url: '/clean/insertCompany',
    method: 'put',
    data: data
  })
}

// 删除userCompany
export function delInsertCompany(companyNum) {
  return request({
    url: '/clean/insertCompany/' + companyNum,
    method: 'delete'
  })
}
