@tag
Feature: AWS Data lake repository
  As a analyst,
  I want to perform counts to compare Oracle vs. Aws Athena transactional system

  @ConteosOracleVsAthena
  Scenario Outline: Perform record counts in Oracle, Athena and then compare
    Given The Data Analyst wants to run a Qlik Sense scripts

      When  The analyst executed the scripts
       | <nombreQvf> |
      Then  Execution completedCerrar
    Examples:
      | id | escenarios | nombreQvf |
      ##@externaldata@./src/test/resources/DataDriven/EjecucionQlikSenseMedellin.xlsx@QlikSenseMedellin@1
   |1   |Verificacion conteos Athena   |ConteosOracleVsAthena|
