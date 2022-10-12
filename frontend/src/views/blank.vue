<template>
  <auto-height-container>
    <el-empty :image-size="200" :description="$t('common.tips.under_development')"></el-empty>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'

export default {
  components: { AutoHeightContainer }
}
</script>
