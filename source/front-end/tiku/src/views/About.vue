<template>
  <div class="about">
    <ModifyProblem></ModifyProblem>
    <h1>This is an about page</h1>
  </div>
</template>

<script>
  import TikuTable from "../components/TikuTable";
  import InputTiku from "../components/InputTiku";
  import VerifyTable from "../components/VerifyTable";
  import ViewProblem from "../components/ViewProblem";
  import ModifyProblem from "../components/ModifyProblem";
  import ViewTags from "../components/ViewTags";
  export default {
    components: {ModifyProblem, ViewProblem, VerifyTable, InputTiku, TikuTable,ViewTags}
  }
</script>



<style>

</style>
