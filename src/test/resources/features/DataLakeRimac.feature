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
       And paso final2
       And verificacion final Search index creation completed successfully

    Examples:
      | id | escenarios | nombreQvf |
      ##@externaldata@./src/test/resources/DataDriven/EjecucionQlikSenseMedellin.xlsx@QlikSenseMedellin@1
   |1   |Verificacion Enmascaramiento Sql Server   |ConteosOracleVsAthena|
