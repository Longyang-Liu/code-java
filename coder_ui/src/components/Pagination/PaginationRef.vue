<template>
  <div :class="{'hidden':hidden}" class="pagination-container" style="height: 2rem; float: right">
    <!-- 分页 -->
    <el-pagination
      class="pagination"
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      background
      :current-page.sync="currentPage"
      :page-sizes="[]"
      :page-size="pageSize"
      layout="total, prev, pager, next, slot, jumper"
      :total="total">
    <span class="pageSizeInput">
      <el-input type="number" style="width: 8rem" size="mini" class="pageSizeBorder" v-model.number="pageSize" @change="handlePageSize" ></el-input> 条/页
    </span>
    </el-pagination>
  </div>
</template>

<script>
import { scrollTo } from '@/utils/pageUtil/scroll-to'

export default {
  name: 'PaginationRef',
  props: {
    total: {
      required: true,
      type: Number
    },
    page: {
      type: Number,
      default: 1
    },
    limit: {
      type: Number,
      default: 10
    },
    pageSizes: {
      type: Array,
      default() {
        return [10, 20, 30, 50]
      }
    },
    layout: {
      type: String,
      default: 'total, sizes, prev, pager, next, jumper'
    },
    background: {
      type: Boolean,
      default: true
    },
    autoScroll: {
      type: Boolean,
      default: true
    },
    hidden: {
      type: Boolean,
      default: false
    }
  },
  computed: {
    currentPage: {
      get() {
        return this.page
      },
      set(val) {
        this.$emit('update:page', val)
      }
    },
    pageSize: {
      get() {
        return this.limit
      },
      set(val) {
        this.$emit('update:limit', val)
      }
    }
  },
  methods: {
    handleSizeChange(val) {
      this.$emit('pagination', { page: this.currentPage, limit: val })
      if (this.autoScroll) {
        scrollTo(0, 800)
      }
    },
    // 改变每一页的数据条数
    sizeChangeHandle (val) {
      this.$emit('pagination', { page: this.currentPage, limit: val })
      if (this.autoScroll) {
        scrollTo(0, 800)
      }
    },

// 改变当前所在页
    currentChangeHandle (val) {
      this.$emit('pagination', { page: val, limit: this.pageSize })
      if (this.autoScroll) {
        scrollTo(0, 800)
      }
    },

// 监听pageSize文本框的变化，当pageSize为空时，设置pageSize的值为0，以防报错
    handlePageSize () {
      if (!this.pageSize) {
        this.pageSize = 10
      }
      this.handleSizeChange(this.pageSize)

    }
  }
}
</script>

<style scoped>
    .pagination-container {
      background: #fff;
      padding: 32px 16px;
    }
</style>
