<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="提单号" prop="tNum">
        <el-input
          v-model="queryParams.tNum"
          placeholder="请输入提单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货主名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入货主名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货主代码" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入货主代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物流公司" prop="company">
        <el-input
          v-model="queryParams.company"
          placeholder="请输入物流公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="集装箱箱号" prop="containerNum">
        <el-input
          v-model="queryParams.containerNum"
          placeholder="请输入集装箱箱号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货物名称" prop="goods">
        <el-input
          v-model="queryParams.goods"
          placeholder="请输入货物名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货重" prop="weight">
        <el-input
          v-model="queryParams.weight"
          placeholder="请输入货重"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['clean:insertLogistics:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['clean:insertLogistics:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['clean:insertLogistics:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['clean:insertLogistics:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="insertLogisticsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="提单号" align="center" prop="tNum" />
      <el-table-column label="货主名称" align="center" prop="name" />
      <el-table-column label="货主代码" align="center" prop="num" />
      <el-table-column label="物流公司" align="center" prop="company" />
      <el-table-column label="集装箱箱号" align="center" prop="containerNum" />
      <el-table-column label="货物名称" align="center" prop="goods" />
      <el-table-column label="货重" align="center" prop="weight" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="200">
        <template #default="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['clean:insertLogistics:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['clean:insertLogistics:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
                      v-show="total>0"
                      :total="total"
                      v-model:page="queryParams.pageNum"
                      v-model:limit="queryParams.pageSize"
                      @pagination="getList"
                    />

    <!-- 添加或修改userLogistics对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="提单号" prop="tNum">
          <el-input v-model="form.tNum" placeholder="请输入提单号" />
        </el-form-item>
        <el-form-item label="货主名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入货主名称" />
        </el-form-item>
        <el-form-item label="货主代码" prop="num">
          <el-input v-model="form.num" placeholder="请输入货主代码" />
        </el-form-item>
        <el-form-item label="物流公司" prop="company">
          <el-input v-model="form.company" placeholder="请输入物流公司" />
        </el-form-item>
        <el-form-item label="集装箱箱号" prop="containerNum">
          <el-input v-model="form.containerNum" placeholder="请输入集装箱箱号" />
        </el-form-item>
        <el-form-item label="货物名称" prop="goods">
          <el-input v-model="form.goods" placeholder="请输入货物名称" />
        </el-form-item>
        <el-form-item label="货重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入货重" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInsertLogistics, getInsertLogistics, delInsertLogistics, addInsertLogistics, updateInsertLogistics } from "@/api/clean/insertLogistics";

export default {
  name: "InsertLogistics",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // userLogistics表格数据
      insertLogisticsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      falg:0,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tNum: null,
        name: null,
        num: null,
        company: null,
        containerNum: null,
        goods: null,
        weight: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询userLogistics列表 */
    getList() {
      this.loading = true;
      listInsertLogistics(this.queryParams).then(response => {
        this.insertLogisticsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        tNum: null,
        name: null,
        num: null,
        company: null,
        containerNum: null,
        goods: null,
        weight: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.tNum)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
    this.falg=1
      this.reset();
      this.open = true;
      this.title = "添加userLogistics";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
        this.falg=0
      this.reset();
      const tNum = row.tNum || this.ids
      getInsertLogistics(tNum).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改userLogistics";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.falg == 0) {
            updateInsertLogistics(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInsertLogistics(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const tNums = row.tNum || this.ids;
      this.$modal.confirm('是否确认删除userLogistics编号为"' + tNums + '"的数据项？').then(function() {
        return delInsertLogistics(tNums);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('clean/insertLogistics/export', {
        ...this.queryParams
      }, `insertLogistics_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
